select CONCAT(Name, '(', LEFT(Occupation, 1), ')')
from OCCUPATIONS
order by Name, LEFT(Occupation, 1);

select CONCAT('There are a total of ', COUNT(Name), ' ', Lower(Occupation), 's.')
from OCCUPATIONS
group by Occupation
order by COUNT(Name), Occupation;