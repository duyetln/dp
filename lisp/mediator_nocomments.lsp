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


(defparameter *box* (make-instance 'ListBox))
(defparameter *entry* (make-instance 'EntryField))

(defgeneric click (button))
(defmethod click (button "ok")
	(print (listB *box*))	;modify any of the data in ListBox here
)
(defmethod click (button "cancel")
	(print (text *entry))	;modify any of the data in EntryField here
)