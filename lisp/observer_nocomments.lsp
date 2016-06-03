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
