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


;;; In case of List
;; リストの末尾に要素を追加するためには、コレクション全体を
;; 走査しなければならず、ベクター同様こちらも非効率的
(defn new-orders '())

(defn add-order [orders order]
  (concat orders (list order)))


;;; In case of Queue
;; 必要なのはキュー。得意な操作を図にするとこんな感じ。
;; List     ←→□□□□□□□□
;; Vector       □□□□□□□□←→
;; Queue      ←□□□□□□□□←
(def new-orders
  clojure.lang.PersistentQueue/EMPTY)

(defn add-order [orders order]
  (conj orders order))

(defn cook-order [orders]
  (cook (peek orders))
  (pop orders))
