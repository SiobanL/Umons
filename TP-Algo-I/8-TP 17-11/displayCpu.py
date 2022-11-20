"""Pour executer ce script, vous devez installer matplotlib"""

import matplotlib.pyplot as plt
import itertools


class CpuPlot(object):
    def __init__(self, n):
        """
        Initialize an object that will be used to display data points on the
        screen.
        n   --  An array of x-values.
        """

        self.n = n
        self.courbes = []
        self.labels = []

    def prepare(self, data, label=None):
        """
        Add a data points.
        """

        self.courbes.append(data)
        self.labels.append(label)

    def reset(self):
        """
        Reset data points. Note that x-values are keeped.
        """

        self.courbes = []

    def draw(self):
        """
        Draw the data points on the screen.
        """

        plt.xlim(max(0, min(self.n) - 5), max(self.n) + 5)
        plt.ylim(0, max([max(t) for t in self.courbes]) + 5)

        plt.xlabel('input size')
        plt.ylabel('milliseconds')
        plt.title('CPU time charts')

        color = itertools.cycle('bgrcmyk')

        for i, t in enumerate(self.courbes):
            if self.labels[i] is None:
                plt.plot(self.n, t, '%s-o' % next(color),
                        label='Data points %d' % i)
            else:
                plt.plot(self.n, t, '%s-o' % next(color),
                        label=self.labels[i])

        plt.legend()
        plt.show()


if __name__ == '__main__':
    # Create a CpuPlot object for x-values 10, 20, 30, 40
    afficheur = CpuPlot([10, 20, 30, 40])

    # Add two sets of data points
    afficheur.prepare([1.1, 2.4, 2.8, 4.1], "Points 1")
    afficheur.prepare([1.2, 4.5, 8.4, 16.5])

    # Display
    afficheur.draw()

    # Don't exit too fast
    input("Press [Enter] to exit.")
