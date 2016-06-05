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

(defparameter *cpu* (make-instance 'CPU))
(defparameter *graphicCard* (make-instance 'GraphicCard))
(defparameter *motherBoard* (list *cpu* *graphicCard*))

(defun totalPrice (list)
	(if (cdr list) (+ (price (car list)) (totalPrice (cdr list)) )  (price (car list)) )
)

;(totalPrice (list *cpu*))
;(totalPrice (list *graphicCard*))
;(totalPrice *motherBoard*)