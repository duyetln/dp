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
	(holySpells
		:initform t
		:reader holySpells)
	)		
)
	
(defclass EnchantedMaze (Maze)
	((wall
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
