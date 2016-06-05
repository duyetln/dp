(defclass Equipment ()
	((power
		:initarg :power
		:initform 0
		:reader power)		
	)
)

(defclass GraphicCard (Equipment)
	((power
		:initform 120)	
	)
)

(defclass CPU (Equipment)
	((power
		:initform 15)	
	)
)

(defparameter *cpu* (make-instance 'CPU))
(defparameter *graphicCard* (make-instance 'GraphicCard))
(defparameter *motherBoard* (list *cpu* *graphicCard*))

(defun normalPrice (list)
	(if (cdr list) (+ (price (car list)) (totalPrice (cdr list)) )  (price (car list)) )
)

(defun comboPrice (list)
	(* 0.8 (if (cdr list) (+ (price (car list)) (totalPrice (cdr list)) )  (price (car list)) ))
)

;(totalPower (list *cpu*))
;(totalPower (list *graphicCard*))
;(totalPower *motherBoard*)