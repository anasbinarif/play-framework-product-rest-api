// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseSeedDataController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def insertCategories: Call = {
    
      () match {
      
        // @LINE:6
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
  }

  // @LINE:13
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:14
    def findAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
  }

  // @LINE:17
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:19
    def getById(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:17
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:18
    def findAll(page:Int = 1, pageSize:Int = 5, sortBy:String = "id"): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products" + play.core.routing.queryString(List(if(page == 1) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("page", page)), if(pageSize == 5) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("pageSize", pageSize)), if(sortBy == "id") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sortBy", sortBy)))))
    }
  
    // @LINE:20
    def update(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:24
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
