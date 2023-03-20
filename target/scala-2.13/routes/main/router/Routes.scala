// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  SeedDataController_0: controllers.SeedDataController,
  // @LINE:13
  CategoryController_1: controllers.CategoryController,
  // @LINE:17
  ProductController_2: controllers.ProductController,
  // @LINE:24
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    SeedDataController_0: controllers.SeedDataController,
    // @LINE:13
    CategoryController_1: controllers.CategoryController,
    // @LINE:17
    ProductController_2: controllers.ProductController,
    // @LINE:24
    Assets_3: controllers.Assets
  ) = this(errorHandler, SeedDataController_0, CategoryController_1, ProductController_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, SeedDataController_0, CategoryController_1, ProductController_2, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.SeedDataController.insertCategories"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """seed-data/insert-categories""", """controllers.SeedDataController.insertCategories"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.create(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.findAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.create(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.findAll(page:Int ?= 1, pageSize:Int ?= 5, sortBy:String ?= "id")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductController.getById(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductController.update(id:Long, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_SeedDataController_insertCategories0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_SeedDataController_insertCategories0_invoker = createInvoker(
    SeedDataController_0.insertCategories,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SeedDataController",
      "insertCategories",
      Nil,
      "GET",
      this.prefix + """""",
      """ Seed data""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_SeedDataController_insertCategories1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("seed-data/insert-categories")))
  )
  private[this] lazy val controllers_SeedDataController_insertCategories1_invoker = createInvoker(
    SeedDataController_0.insertCategories,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SeedDataController",
      "insertCategories",
      Nil,
      "GET",
      this.prefix + """seed-data/insert-categories""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_CategoryController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_create2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CategoryController_1.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """categories""",
      """ Category Routes""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_CategoryController_findAll3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_findAll3_invoker = createInvoker(
    CategoryController_1.findAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "findAll",
      Nil,
      "GET",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ProductController_create4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductController_create4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ProductController_2.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """products""",
      """ Product routes""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ProductController_findAll5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductController_findAll5_invoker = createInvoker(
    ProductController_2.findAll(fakeValue[Int], fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "findAll",
      Seq(classOf[Int], classOf[Int], classOf[String]),
      "GET",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ProductController_getById6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getById6_invoker = createInvoker(
    ProductController_2.getById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_ProductController_update7_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_update7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ProductController_2.update(fakeValue[Long], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "update",
      Seq(classOf[Long], classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ProductController_delete8_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_delete8_invoker = createInvoker(
    ProductController_2.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_SeedDataController_insertCategories0_route(params@_) =>
      call { 
        controllers_SeedDataController_insertCategories0_invoker.call(SeedDataController_0.insertCategories)
      }
  
    // @LINE:7
    case controllers_SeedDataController_insertCategories1_route(params@_) =>
      call { 
        controllers_SeedDataController_insertCategories1_invoker.call(SeedDataController_0.insertCategories)
      }
  
    // @LINE:13
    case controllers_CategoryController_create2_route(params@_) =>
      call { 
        controllers_CategoryController_create2_invoker.call(
          req => CategoryController_1.create(req))
      }
  
    // @LINE:14
    case controllers_CategoryController_findAll3_route(params@_) =>
      call { 
        controllers_CategoryController_findAll3_invoker.call(CategoryController_1.findAll)
      }
  
    // @LINE:17
    case controllers_ProductController_create4_route(params@_) =>
      call { 
        controllers_ProductController_create4_invoker.call(
          req => ProductController_2.create(req))
      }
  
    // @LINE:18
    case controllers_ProductController_findAll5_route(params@_) =>
      call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("pageSize", Some(5)), params.fromQuery[String]("sortBy", Some("id"))) { (page, pageSize, sortBy) =>
        controllers_ProductController_findAll5_invoker.call(ProductController_2.findAll(page, pageSize, sortBy))
      }
  
    // @LINE:19
    case controllers_ProductController_getById6_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_getById6_invoker.call(ProductController_2.getById(id))
      }
  
    // @LINE:20
    case controllers_ProductController_update7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_update7_invoker.call(
          req => ProductController_2.update(id, req))
      }
  
    // @LINE:21
    case controllers_ProductController_delete8_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_delete8_invoker.call(ProductController_2.delete(id))
      }
  
    // @LINE:24
    case controllers_Assets_versioned9_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_3.versioned(path, file))
      }
  }
}
