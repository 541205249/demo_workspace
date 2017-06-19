# 带你体验另一种数据加载方式—Loaders及LoaderManager



## 0、 本篇文章的目的

- 了解Loader及LoaderManager的特性及用途
        
- 简单使用Loader
        
- 了解Loader及LoaderManager的工作原理
        
- 自定义Loader

- 探讨Loader在开发工程中遇到的问题

## 1、什么是Loader及LoaderManager

- 在Android的设计原则中，任何耗时的操作都不建议放在UI线程之中。所以类似于网络操作、数据库操作等耗时的操作都需要使用异步的实现。

- 在Android 3.0中，官方推出了一种新的**数据加载组件——Loader**（用来取代老的managedQuery），它可以方便我们在Activity和Fragment中**异步加载数据**，而不是使用线程或AsyncTask。在Android 3.0之前，我们也可以使用Loader，方案就是使用Android提供的support v4支持库。

- LoaderManager是Activity/Fragment中的一个实例，用来控制和管理Loader。

- **Loader组件具有以下特点：**
	
	- 1、可用于每个 Activity/Fragment。
	- 2、支持**异步**加载数据。
	- 3、监控其数据源并在**内容变化时**传递新结果。
	- 4、关联Activity/Fragment的**生命周期**。
	- 5、在Activity/Fragment配置更改后重建加载器时，会自动重新连接上一个Loader的数据。 因此，它们**无需重新查询其数据**。

## 2、简单示例
        
- 源码下载：[https://github.com/541205249/demo_workspace.git](https://github.com/541205249/demo_workspace.git)

- **少啰嗦，先看东西**
        
## 3、涉及到的类和接口

### 在应用中使用加载器时，可能会涉及到多个类和接口。 下表汇总了这些类和接口：

![](http://i.imgur.com/kBhyn5e.png)

上表中的类和接口是您在应用中用于实现加载器的基本组件。 并非您创建的每个加载器都要用到上述所有类和接口。但是，为了初始化加载器以及实现一个 Loader 类（如 CursorLoader），您始终需要要引用 LoaderManager。 下文将为您展示如何在应用中使用这些类和接口。

### 关系图：

![](http://i.imgur.com/hewuONu.png)

### **具体的方法及参数说明：**


**- 1、initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) 启动加载器**
		
	id:用于标识加载器的唯一 ID;
	args:在构建时提供给加载器的可选参数(可为空)；
	callback：LoaderCallbacks的实现，LoaderManager将调用此实现来报告加载器事件。
	
**- 2、restartLoader()  重启加载器**

**- 3、onCreateLoader()：针对指定的 ID 进行实例化并返回新的 Loader**

	以下为CursorLoader构造方法的参数：

	uri：用于检索内容的 URI
	projection：要返回的列的列表。传递 null 时，将返回所有列，这样会导致效率低下
	selection：一种用于声明要返回哪些行的过滤器，采用 SQL WHERE 子句格式（WHERE 本身除外）。传递 null 时，将为指定的 URI 返回所有行
	selectionArgs：您可以在 selection 中包含 ?s，它将按照在 selection 中显示的顺序替换为 selectionArgs 中的值。该值将绑定为字串符
	sortOrder：行的排序依据，采用 SQL ORDER BY 子句格式（ORDER BY 自身除外）。传递 null 时，将使用默认排序顺序（可能并未排序）

**- 4、onLoadFinished(Loader<Cursor> loader, Cursor data) 当先前创建的加载器完成加载时，将调用此方法**

**- 5、onLoaderReset(Loader loader)  此方法将在先前创建的加载器重置且其数据因此不可用时调用。 通过此回调，您可以了解何时将释放数据，因而能够及时移除其引用**

## 4、源码浅析

###涉及到的类：

	1. LoaderManager
	2. LoaderManagerImpl
	3. LoaderManager.LoaderCallbacks
	4. Loader
	5. AsyncTaskLoader
	6. CursorLoader

###带着这些疑问一起来欣赏源码：

- LoaderManager是如何关联Activity/Fragment的？

		1、获取LoaderManager实例
		FragmentController.getLoaderManager()
		FragmentHostCallback.getLoaderManagerImpl() -> getLoaderManager()

		2、创建/重设Loader
		LoaderManager.initLoader();
		LoaderManager.createAndInstallLoader -> createLoader

		3、启动Loader
		Activity.onStart()
		FragmentController.doLoaderStart()
		FragmentHostCallback.doLoaderStart()
		LoaderManager.doStart() -> start()
		Loader.startLoading()

		4、停止Loader
		Activity.performStop()
		FragmentController.performStop()
		FragmentHostCallback.performStop()
		Loader.stopLoading

		5、销毁Loader

- Loader何时被创建？
		LoaderManager.initLoader();
		LoaderManager.createAndInstallLoader -> createLoader
		
- 何时执行数据获取操作？

		Loader.startLoading()
		Loader子类（最终实现类）.onStartLoading()
		Loader.forceLoad() -> onForceLoad()
		AsyncTaskLoader.onForceLoad() 执行AsyncTask
		最终由实现类的loadInBackground()执行获取数据的操作

- 客户端是如何拿到数据的？

		AsyncTaskLoader中的AsyncTask.onPostExecute()回调方法中调用dispatchOnLoadComplete()
		Loader.deliverResult() -> mListener.onLoadComplete()
		LoaderManager中实现了onLoadComplete() -> callOnLoadFinished() 并回调mCallbacks.onLoadFinished()

- 通过什么方式监听数据的变化并重新加载数据？

		注册ForceLoadContentObserver监听
		当有数据发生变化时，ForceLoadContentObserver回调onChange()
		Loader.onContentChanged() -> forceLoad()
		

## 5、自定义用法
	
1. 实现AsyncTaskLoader；
2. 无ContentProvider的数据源实现Loader；


## 6、参考资料
官方API：[https://developer.android.google.cn/guide/components/loaders.html#app](https://developer.android.google.cn/guide/components/loaders.html#app)

 Android中Loader及LoaderManager的使用（附源码下载）：[http://blog.csdn.net/iispring/article/details/48834767](http://blog.csdn.net/iispring/article/details/48834767)
