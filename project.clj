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
      Extensos and constructos are defined using the @(link defextenso) 
      and @(link defconstructo) macros, and result in protocols and records that
      are in all respects fully compatible with those defined with 
      @(link clojure.core/defprotocol) and @(link clojure.core/defrecord).
      )
(defproject extensomatic "0.1.0"
  :description "Extensomatic"
  :url "https://github.com/greenh/Extensomatic"
  :target-dir "bin"
  :dependencies [])