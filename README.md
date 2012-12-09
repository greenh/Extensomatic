# Extensomatic

Extensomatic is a package for Clojure that allows Clojure programmers to 
define simple data structures. It does this in a way that's arguably more convenient 
and concise than Clojure's native`defprotocol` and `defrecord` macros. Extensomatic 
structures always compile in well-defined ways into Clojure protocols and records, however,
so the structures it creates are fully interoperable with all aspects of Clojure.

As preliminary, be aware that Extensomatic strives to be entirely non-pretentious:
it makes no claimes to such properties as generality, extensibility, universality, robustness, 
flexibility, upgradeability, etc., that are often advertised for data 
structuring systems. It's a purely bottom-up, convenience-driven design that just seems 
to work pretty well for most simple needs of simple programs.  

Extensomatic structures are specified in terms of two artifacts, _extensos_ and _constructos_,
which are defined using the 
[`defextenso`](http://greenh.github.com/Extensomatic/doc/dark/extensomatic.extensomatic.html#defextenso)
and 
[`defconstructo`](http://greenh.github.com/Extensomatic/doc/dark/extensomatic.extensomatic.html#defconstructo)
macros, respectively. 

Extensos define fragments of records, and may specify fields (which may be initialized), 
method implementations, and other extensos. If an extenso includes another, it acquires all
of the included extenso's fields, method implementations, and included extensos. Because extensos 
can include other extensos, the basis exsists for defining hierarchies of extensos---but with 
limitations: once a method is implemented or a field initialized, the implementation or value
can't be changed. 

A constructo, on the other hand, is a complete specification for a class or record. 
Like an extenso it can define fields 
and method implementations, and include extensos; but once defined, it's not susceptible
to further extension. Because a constructo is a complete class, it has a constructor 
function and thus can be instantiated as needed. 

The net effect, then, is one of extensos acting as building blocks, while constructos 
are composed from these blocks plus whatever additional functionality is needed to make
them hang together. The composition process is entirely textual: `defconstructo` 
effectively just concatenates the content of all included extensos plus whatever content is
defined in the constructo per se, and then hands the resulting composite off to the
tender mercies of Clojure. 

The perceived convenience of Extensomatic, as compared to standard Clojure records
and protocols, is most apparent when defining simple records with a few methods and fields.
In Clojure, one has to define a protocol, _and_ a record, _and_ often at least one function to
handle field intitialization. While these multiple parts and pieces are obviously a
fully general mechanism, they can also be a tiresome nuisance to write and maintain. 
Extensomatic gets around this by incorporating the whole works into a single 
specification. It's hardly perfect, but experience indicates that it's not only 
convenient for many applications, but that it's a nice base for building further classes 
of structures as well.

## A quick summary

An extenso:
* defines a fragment of a record.
* may define fields, for which initialization values may be specified.
* may include other extensos.
* may supply an initialization value for any _uninitialized_ field of an include extenso. 
* may define method implementations that make use of local or included fields.
* may specify protocols or interfaces, and provide method implementations for those 
* may _not_ change or replace any method implementation inherited from an incorporated extenso.
* may _not_ alter the value of a field initialized in an incorporated extenso.
* generates a Clojure protocol that defines the extenso's local method signatures.

A constructo:
* defines a complete, instantiable record.
* may define fields, for which initialization values may be specified.
* may include other extensos.
* may supply an initialization value for any _uninitialized_ field of an include extenso. 
* may define method implementations that make use of local or included fields.
* may _not_ change or replace any method implementation inherited from an incorporated extenso.
* may _not_ alter the value of a field initialized in an incorporated extenso.
* generates a Clojure record.
* generates an interface that describes the constructo's local method signatures.
* generates a constructor function that accepts values for uninitialized fields.

## Documentation 

[Extensomatic user guide](http://greenh.github.com/Extensomatic/Extensomatic.html) (TBD). 

[Extensomatic API](http://greenh.github.com/Extensomatic/doc/dark/extensomatic.extensomatic.html) 

## Getting Extensomatic

Extensomatic is available through [Clojars](https://clojars.org/extensomatic), and can 
be retrieved from there.

## License

Copyright (c) 2011-2012 Howard Green. All rights reserved.
            
The use and distribution terms for this software are covered by the
Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this distribution.
By using this software in any fashion, you are agreeing to be bound by
the terms of this license.
 
You must not remove this notice, or any other, from this software.