select distinct CITY
from STATION
where CITY REGEXP '^[^aeiou]' or CITY REGEXP '[^aeiou]$';