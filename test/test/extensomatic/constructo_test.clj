(ns test.extensomatic.constructo-test
  (:use
    [extensomatic.extensomatic]
    )
  )

(defprotocol Zotz
  (zotz-a [this])
  (zotz-b [this something])
  )

(defprotocol Zapz
  (zapz-a [this])
  (zapz-b [this something])
  )


(defextenso Extxx1 [] [aa bb cc] 
  (aa-of [this] aa)
  (bb-cc [this] (str bb (if (= bb cc) " is " " is not ") cc))
  )

(defextenso Extxx2 []  [qqq rrr]
  (qqq-of [this] qqq)
  (rrr-qqq [this ss] (str qqq rrr ss))
  Zotz
  (zotz-a [this] (.toUpperCase (str qqq)))
  (zotz-b [this something] (str something qqq rrr))
  )

(defextenso Dated [] []
  (date [this] (.format (java.text.SimpleDateFormat.) (java.util.Date.))))

(defconstructo UPoo [] [x y z])

(defconstructo PooPoo [Extxx1 Dated] [poo] 
  (poo-of [this] poo)
  (poo-vec [this] [aa bb cc poo])
  java.lang.Object
  (toString [this] (str "#<PooPoo " poo " with " aa ">"))
  )

(defconstructo PooPoo2 [Extxx1 Dated] [] 
  java.lang.Object
  (toString [this] (str "#<PooPoo2 " (date this) " with " aa ">"))
  )

(defconstructo PooPoo3 
  [(Extxx2 (qqq 128.5) (rrr -11117)) Dated] 
  [(eeeg nil) poo3 (yyyo "No.")]
  (poo3-of [this] (.toUpperCase (str poo3 yyyo eeeg)))
  Zapz 
  (zapz-a [this] 3)
  (zapz-b [this something] (+ 3 something))
  java.lang.Object
  (toString [this] (str "#<PooPoo2 " (date this) " with " poo3 ">"))
  )

(defextenso Flexibot [(Extxx2 (qqq "qqq") rrr)] [qq (nada (ref [])) zz (u2u "No.") ]
  (nada-of [this] @nada)
  (nada-nada [this nothing] (dosync (alter nada conj nothing ))))

(defconstructo Doodle [Extxx1 Flexibot] [(yorick (ref 0))]
  (alas [this] (str @yorick " " @nada)))

(defconstructo Dwibble [Extxx1 Flexibot] [(yorick (ref 0))]
  { :def-sym deftype :new-prefix new- } 
  (pre-alas [this] (str @yorick " " @nada)))

(defconstructo Dwadle [Extxx1 Flexibot] [(yorick (ref 0))]
  { :def-sym deftype :new-sym kerzap } 
  (post-alas [this] (str @yorick " " @nada)))




