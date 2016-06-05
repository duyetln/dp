;There are no class functions in Lisp. There are functions that act on data in classes, but those are callable everywhere so essentially the only thing required is to define the methods that modify class data

;If there's no data and in fact just output (such as printing a line in this toy example), there is actually no need for classes at all. Simply defining different cases for a generic function

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


;Button, ListBox and EntryField only need to inherit from a common class if there is actually class data they need to share, not functions. In this case, none of them have the same data so in fact they are essentially all different classes 
(defparameter *box* (make-instance 'ListBox))
(defparameter *entry* (make-instance 'EntryField))

(defgeneric click (button))
(defmethod click (button "ok")-
	(print (listB *box*))	;modify any of the data in ListBox here
)
(defmethod click (button "cancel")
	(print (text *entry*))	;modify any of the data in EntryField here
)

;(click "ok")
;(click "cancel")