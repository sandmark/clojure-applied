(ns my-cljapplied.ch2.orders)

(defn new-orders [] [])

(defn add-order [orders order]
  (conj orders order))

(defn cook [] ,,,)

(defn cook-order [orders]
  (cook (first orders)) (rest orders))
