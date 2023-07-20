class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        
        for asteroid in asteroids:
            # Check if the current asteroid is moving to the right or left
            if asteroid > 0:
                stack.append(asteroid)
            else:
                # When asteroid is moving to the left (negative direction)
                while stack and stack[-1] > 0 and stack[-1] < abs(asteroid):
                    # The current asteroid will destroy the one in the stack moving to the right
                    stack.pop()
                
                # If there are no asteroids moving to the right or the current asteroid survives the collision
                if not stack or stack[-1] < 0:
                    stack.append(asteroid)
                # If the current asteroid destroys the one in the stack moving to the right
                elif stack[-1] == abs(asteroid):
                    stack.pop()
        
        return stack
