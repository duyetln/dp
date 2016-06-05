(defclass Equipment ()
	((price
		:initarg :power
		:reader price)		
	)
)

(defclass GraphicCard (Equipment)
	((price
		:initform 45)	
	)
)

(defclass CPU (Equipment)
	((price
		:initform 75)	
	)
)

(defclass Motherboard (Equipment)
	((price
		:initform 150)	
	)
)

(defparameter *cpu* (make-instance 'CPU))
(defparameter *graphicCard* (make-instance 'GraphicCard))
(defparameter *motherBoard* (make-instance 'Motherboard))
(defparameter *Bundle* (list *cpu* *graphicCard* *motherBoard*))


(defun oneItemPrice (lst)
	(price (car lst)) 
)

(defun twoItemPrice (lst)
	(if (cdr lst) 
		(if (> (car lst) (twoItemPrice (cdr lst))) (price car lst) (twoItemPrice (cdr lst) )) 
		(price (car lst)))
)

(defun BundlePrice (lst)
	(if (cdr lst) (+ (price (car lst)) (totalPrice (cdr lst)) )  (price (car lst)) )
)

;(oneItemPrice (list *cpu*))
;(BundlePrice *motherBoard*)