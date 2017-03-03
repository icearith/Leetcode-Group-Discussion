class Solution(object):
    def islandPerimeter(self, grid):
        def water_around(y, x):
            return ((x == 0              or grid[y][x-1] == 0) +
                    (x == len(grid[0])-1 or grid[y][x+1] == 0) +
                    (y == 0              or grid[y-1][x] == 0) +
                    (y == len(grid)-1    or grid[y+1][x] == 0) )
        return sum(water_around(y, x) for y in xrange(len(grid)) for x in xrange(len(grid[0])) if grid[y][x])

s = Solution()
# input_grid = [[0,1,0,0],
#  [1,1,1,0],
#  [0,1,0,0],
#  [1,1,0,0],
#  [0,0,0,0]]

# input_grid = [[1,1,1,0]]
#input_grid = [[1],[0]]
# input_grid = [[0],[1]]
# input_grid = [[1,0]]
input_grid = [[1,1,1],[1,0,1]]
print s.islandPerimeter(input_grid)
