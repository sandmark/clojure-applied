(ns my-cljapplied.ch1.protocols
  (:require [my-cljapplied.ch1.money :refer [+$ zero-dollers]]
            [my-cljapplied.ch1.multimethods :refer [cost-of]])
  (:import [my_cljapplied.ch1.validate Ingredient Recipe]))

(defprotocol Cost
  (cost [entity store]))


(extend-protocol Cost
  Recipe
  (cost [recipe store]
    (reduce +$ zero-dollers
            (map #(cost % store)
                 (:ingredients recipe))))

  Ingredient
  (cost [ingredient store]
    (cost-of store ingredient)))


(defprotocol TaxedCost
  (taxed-cost [entity store])
  (tax-rate [store]))


(extend-protocol TaxedCost
  Object ;; default fallthrough
  (taxed-cost [entity store]
    (if (satisfies? Cost entity)
      (do (extend-protocol TaxedCost
            (class entity)
            (taxed-cost [entity store]
              (* (cost entity store)
                 (inc (tax-rate store)))))
          (taxed-cost entity store))
      (assert false (str "Unhandled entity: " entity)))))
