(defclass Equipment ()
	((price
		:initarg :price
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

(defun totalPrice (lst)
	(if (cdr lst) (+ (price (car lst)) (totalPrice (cdr lst)) )  (price (car lst)) )
)

;(totalPrice (list *cpu*))
;(totalPrice (list *graphicCard*))
;(totalPrice *motherBoard*)