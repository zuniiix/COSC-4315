;; Polymorphism example
(ns hw3Example
  (:gen-class))

(defprotocol Fruit
  (price [this] "Generic fruit price"))

(defrecord Strawberry []
  Fruit
  (price [_] 2.50))

(defrecord Kiwi []
  Fruit
  (price [_] 3.45))

(defn describe-price [fruit]
  (println (str "This fruit costs: $" (format "%.2f" (price fruit)))))

(def strawberry (->Strawberry))
(def kiwi (->Kiwi))

(describe-price strawberry)  ; Output: This fruit costs: $2.50
(describe-price kiwi)        ; Output: This fruit costs: $3.45


;; Multimethod example
(defprotocol Fruit
  (price [this] "Generic fruit price"))

(defrecord Strawberry []
  Fruit
  (price [_] 2.50))

(defrecord Kiwi []
  Fruit
  (price [_] 3.45))

(defprotocol Discount
  (apply-discount [this price] "Apply discount to the given price"))

(defrecord PercentageDiscount [percentage]
  Discount
  (apply-discount [_ price] (* price (- 1 (/ percentage 100.0)))))

(defrecord FixedDiscount [amount]
  Discount
  (apply-discount [_ price] (- price amount)))

(defmulti describe-price (fn [fruit discount] [:class (class fruit) :discount (class discount)]))

(defmethod describe-price [:class Strawberry :discount PercentageDiscount] [fruit discount]
  (let [discounted-price (apply-discount discount (price fruit))]
    (println (str "Strawberry with percentage discount costs: $" (format "%.2f" discounted-price)))))

(defmethod describe-price [:class Kiwi :discount FixedDiscount] [fruit discount]
  (let [discounted-price (apply-discount discount (price fruit))]
    (println (str "Kiwi with fixed discount costs: $" (format "%.2f" discounted-price)))))

(def strawberry (->Strawberry))
(def kiwi (->Kiwi))

(def percentage-discount (->PercentageDiscount 10))  ; 10% discount
(def fixed-discount (->FixedDiscount 1.00))         ; $1.00 discount

(describe-price strawberry percentage-discount)  ; Output: Strawberry with percentage discount costs: $2.25
(describe-price kiwi fixed-discount)             ; Output: Kiwi with fixed discount costs: $2.45