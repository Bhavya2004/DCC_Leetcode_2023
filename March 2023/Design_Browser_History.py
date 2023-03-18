class BrowserHistory:
# In the __init__ method, we initialize the object with the homepage and set the history list to contain only the homepage. We also set the current_index to 0, since we are currently on the homepage.
    def __init__(self, homepage: str):
        self.history = [homepage]
        self.current_index = 0
        
# In the visit method, we add the url to the history list by slicing the list up to the current_index+1 and appending the url. We also increment the current_index to the end of the history list, effectively clearing any forward history.
    def visit(self, url: str) -> None:
        self.history = self.history[:self.current_index+1] + [url]
        self.current_index += 1
        
# In the back method, we move back in the history by setting the current_index to max(0, self.current_index - steps). This makes sure that we don't go beyond the beginning of the history list. We then return the current url at the new current_index.
    def back(self, steps: int) -> str:
        self.current_index = max(0, self.current_index - steps)
        return self.history[self.current_index]
        
# In the forward method, we move forward in the history by setting the current_index to min(len(self.history)-1, self.current_index + steps). This makes sure that we don't go beyond the end of the history list. We then return the current url at the new current_index.
    def forward(self, steps: int) -> str:
        self.current_index = min(len(self.history)-1, self.current_index + steps)
        return self.history[self.current_index]
        


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)