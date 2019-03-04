(ns my-cljapplied.ch1.multimethods
  (:require [my-cljapplied.ch1.money :refer :all])
  (:import [my_cljapplied.ch1.validate Ingredient Recipe]))

(defrecord Store [,,,])

(defn cost-of [store ingredient] ,,,)

(defmulti cost (fn [entity store] (class entity)))

(defmethod cost Recipe [recipe store]
  (reduce +$ zero-dollers
          (map #(cost % store)
               (:ingredients recipe))))

(defmethod cost Ingredient [ingredient store]
  (cost-of store ingredient))
