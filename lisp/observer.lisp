;Two possibilities, all objects should be notified or only some should be notified depending on what event happened.
;When all observers should be notified, we can create a generic function with implementations for each class
(defclass ListBox ()
	((listB 
		:initarg :listB)
		:initform "setList"
		:accessor listB)
)

(defclass EntryField ()
	((text
		:initarg :text
		:initform "setText"
		:accesor text))
)

(defclass Button ()
	((click
		:initarg :click)
		:initform "Click"
		:accessor click)
)

(defgeneric notify (object))
(defmethod notify (object ListBox)
	(print (listB object))
)
(defmethod notify (object EntryField)
	(print (text object))
)
(defmethod notify (object Button)
	(print (click object))
)

(defparameter *box* (make-instance 'ListBox))
(defparameter *entry* (make-instance 'EntryField))
(defparameter *button* (make-instance 'Button))
(defparameter *observers* (list *box* *entry* *button*))
(dolist (x *observers*) (notify x))

;When it needs to be filtered out by type, essentially we have to do what we did for mediator