(ns test.extensomatic.extenso-test
  (:use
    [extensomatic.extensomatic]
    )
  )

(defprotocol Zot
  (zot-a [this])
  (zot-b [this something])
  )

(defprotocol Zap
  (zap-a [this])
  (zap-b [this something])
  )


(defextenso Ext1 [] [aa bb cc] 
  (aa-of [this] aa)
  (bb-cc [this] (str bb (if (= bb cc) " is " " is not ") cc))
  )

(defextenso Ext2 []  [qqq rrr]
  (qqq-of [this] qqq)
  (rrr-qqq [this ss] (str qqq rrr ss))
  Zot
  (zot-a [this] (.toUpperCase (str qqq)))
  (zot-b [this something] (str something qqq rrr))
  )

(defextenso Aaaaaaa [Ext1 Ext2] [daphne chloe avocado]
  (doodl [this]))

(defextenso Bbbbbbb [(Ext1 aa bb cc) (Ext2 qqq rrr)] [alfa beta]
  (piddle [this that something-else] [aa bb qqq rrr alfa something-else])
  Zap 
  (zap-a [this] 42)
  (zap-b [this something] 43)
  )

(defextenso Ccccccc [(Ext1 aa (bb 3) cc) (Ext2 (qqq nil) (rrr "rrr"))] [alfa (beta 19) (gamma 3) ])


(defextenso Ccccccc 
  [(Ext1 aa (bb 3) cc) 
   (Ext2 (qqq nil) (rrr "rrr"))] 
  [alfa (beta 19) (gamma 3) ])

(defextenso Ddddddd 
  [(Ext1 aa (bb 3 :qqq "qqq") (cc :zzz "Zzz"))]
  [(abc :opt "Opt") fed (ghi "ghi" :doodle 3)])