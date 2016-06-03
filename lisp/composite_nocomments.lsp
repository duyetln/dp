(defclass Equipment ()
	((power
		:initarg :power
		:initform 0
		:reader power)		
	(price
		:initarg :price
		:initform 0
		:reader price)
	)
)

(defclass GraphicCard (Equipment)
	((power
		:initform 120)		
	(price
		:initform 45)
	)
)

(defclass CPU (Equipment)
	((power
		:initform 15)		
	(price
		:initform 75)
	)
)

(defparameter *cpu* (make-instance 'CPU))
(defparameter *graphicCard* (make-instance 'GraphicCard))
(defparameter *motherBoard* (list *cpu* *graphicCard*))
(defun totalPower (list)
	(if (cdr list) (+ (power (car list)) (totalPower (cdr list)) )  (power (car list)) )
)
(defun totalPrice (list)
	(if (cdr list) (+ (price (car list)) (totalPrice (cdr list)) )  (price (car list)) )
)

(totalPower (list *cpu*))
(totalPower (list *graphicCard*))
(totalPower *motherBoard*)