(defclass Equipment ()
	((price
		:initarg :price
		:initform 0
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

;All composites and individuals passed as lists, all elements in lists can be grabbed the same way
(defparameter *cpu* (make-instance 'CPU))
(defparameter *graphicCard* (make-instance 'GraphicCard))
(defparameter *motherBoard* (list *cpu* *graphicCard*))

(defun totalPrice (list)
	(if (cdr list) (+ (price (car list)) (totalPrice (cdr list)) )  (price (car list)) )
)

;Make sure to pass in a list
(totalPrice (list *cpu*))
(totalPrice (list *graphicCard*))
(totalPrice *motherBoard*)