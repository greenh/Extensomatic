#_ ( Copyright (c) 2012 Howard Green. All rights reserved.
                
     The use and distribution terms for this software are covered by the
     Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
     which can be found in the file epl-v10.html at the root of this distribution.
     By using this software in any fashion, you are agreeing to be bound by
     the terms of this license.
     
     You must not remove this notice, or any other, from this software.
     )

#_ (* Provides a set of macros for constructing data-containing objects in
      Clojure. It allows construction of two principle kinds of entities,
      @(i extensos) and @(i constructos), which are significantly enhanced
      analogs of Clojure's native protocol and record entities respectively.
      Extensos and constructos are defined using the 
      @(lt "extensomatic.extensomatic.html#defextenso" defextenso) 
      and @(lt "extensomatic.extensomatic.html#defconstructo" defconstructo) 
      macros, and result in protocols and records that
      are in all respects fully compatible with those defined with 
      @(lt "extensomatic.extensomatic.html#defconstructo" defconstructo)
      @(lt "http://clojure.github.com/clojure/clojure.core-api.html#clojure.core/defprotocol"
           defprotocol) 
      and @(lt "http://clojure.github.com/clojure/clojure.core-api.html#clojure.core/defrecord" 
               defrecord).
      @p Extensomatic is an open-source project. Source materials and documentation are
      located at its @(linkto "https://github.com/greenh/extensomatic" home). 
      )

(defproject extensomatic "0.2.0"
  :description "Extensomatic"
  :url "https://github.com/greenh/Extensomatic"
  :target-path "bin/"
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"] 
  :test-paths ["test"]
  :compile-path "classes"
  :dependencies [
    [org.clojure/clojure "1.4.0"]
    ]
  :plugins [
    [no-man-is-an-island/lein-eclipse "2.0.0"]
    [cjd "0.1.0-SNAPSHOT"]
    [lein-clojars "0.9.1"]
    ]
  :dev-dependencies [
    [cjd "0.1.0-SNAPSHOT"]
    ]
  
  :cjd-source "src/clojure"
  :cjd-dest "doc/dark"
  :cjd-opts { :theme :dark 
             :title "Extensomatic" :v #{:f :n} :overview "project.clj"
             :requires "extensomatic-cjd.extensomatic-cjd" }
  )


 