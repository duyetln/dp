(defclass Maze ()
	((room
		:initarg :room
		:initform "Room"
		:reader room)		
	(wall
		:initarg :wall
		:initform "Wall"
		:reader wall)
	)
)

(defclass HauntedMaze (Maze)
	((room
		:initform "HauntedRoom")
	(wall
		:initform "HauntedWall")
	(holySpells
		:initform t
		:reader holySpells)
	)		
)
	
(defclass EnchantedMaze (Maze)
	((room
		:initform "EnchantedRoom")
	(wall
		:initform "EnchantedWall")
	(magicSpells
		:initform t
		:reader magicSpells)
	)
)

(defclass HybridMaze (EnchantedMaze HauntedMaze) ())	;classes earlier in the list are considered more specific, so HybridMaze will inherit wall and room from EnchantedMaze

	
(defgeneric createMaze (name))

(defmethod createMaze(name "Maze")
	(defparameter *mazeGame* (make-instance 'Maze))
)
(defmethod createMaze (name "HauntedMaze")
	(defparameter *mazeGame* (make-instance 'HauntedMaze))
)
(defmethod createMaze(name "EnchantedMaze")
	(defparameter *mazeGame* (make-instance 'EnchantedMaze))
)
(defmethod createMaze(name "HybridMaze")
	(defparameter *mazeGame* (make-instance 'HybridMaze))
)

;You can now test the creation by checking wall and room types
;(createMaze "Maze")
;(room *mazeGame*)
;(createMaze "HauntedMaze")
;(holySpells *mazeGame*)
;(room *mazeGame*)
;(createMaze "EnchantedMaze")
;(magicSpells *mazeGame*)
;(room *mazeGame*)
;(createMaze "HybridMaze")
;(room *mazeGame*)
;(magicSpells *mazeGame*)
;(holySpells *mazeGame*)


;Note the problem is that the slot *mazeGame* is being overwritten each time
;There's not way to dynamically create slot names because variables need to be bound to be passed to a function so you can't do something like
;(defun dynamicVar (x) (defparameter x 10))
;(dynamicVar *test*)
;well give you an error because *test* is unbound
;Classes also don't have functions. Both defgeneric and defclass define abstract data; defclass is more like a struct in C
;All methods are defined with defmethod
;Only solution is something like
;(createMaze "Maze")
;(defparameter *basicMaze* *mazeGame*)
;(createMaze "HauntedMaze")
;(defparameter *hauntedMaze* *mazeGame*)
;...
;But since you have to rename it every time, this is basically equivalent to just creating a new object (aka no point to calling a single factory method)