from shapes import *

p = Point(50, 50)
p.draw()
for i in range(5):
    p.translate(Point(10, 20))
    p.draw()
    
l = Segment(Point(5, 5), p)
l.draw(True)

x_axis = Segment(Point(-10, 0), Point(200, 0))
x_axis.draw()
y_axis = Segment(Point(0, -10), Point(0, 200))
y_axis.draw()

c = Point(70, 30)
box = Rectangle(60, 40, c)
box.draw()
center = box.find_center()
center.draw()

sq = Square(40, Point(20, 20))
sq.draw()

origin = Point(0, 0)
origin.attract_pen()

input('Press enter to quit.') 
