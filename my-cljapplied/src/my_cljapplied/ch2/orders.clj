(ns my-cljapplied.ch2.orders
  "FIFO in Clojure")

;;; In case of Vector
;; `rest`はベクターではなくシーケンスを返す。
;; つまり余計なデータ変換のコストが発生するということであり、非効率的
(defn new-orders [] [])

(defn add-order [orders order]
  (conj orders order))

(defn cook [] ,,,)

(defn cook-order [orders]
  (cook (first orders)) (rest orders))
