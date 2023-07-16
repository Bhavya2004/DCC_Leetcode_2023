class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        d = {i:j for j, i in enumerate(req_skills)}
        n = len(req_skills)
        people = [reduce(or_, [0]+[1<<d[i] for i in j]) for j in people]
        @cache
        def ans(person, skills):
            if person == len(people):
                return [] if skills == (1<<n)-1 else[0]*17
            return min(ans(person+1, skills), [person] + ans(person+1, skills|people[person]), key = len)
        return ans(0, 0)