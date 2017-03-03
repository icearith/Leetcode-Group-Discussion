import os
import unicodecsv as csv

SOLUTION_PATH = '../Leetcode'

to_csv = []
problems = os.listdir(SOLUTION_PATH)

header = {'problem':'-'}
rows = []

for problem in problems:
    problem_path = os.path.join(SOLUTION_PATH, problem)
    persons_solved = [ name for name in os.listdir(problem_path) if os.path.isdir(os.path.join(problem_path, name)) ]

    problem_data = {'problem': problem}
    for person in persons_solved:
        header[person] = '-'
        problem_data[person] = '✓'

    rows.append(problem_data)

to_csv.append(header)
#rows.sort(key=lambda e: e['problem'], reverse=True)
to_csv += rows

keys = to_csv[0].keys()
with open('data.csv', 'wb') as output_file:
    dict_writer = csv.DictWriter(output_file, keys)
    dict_writer.writeheader()
    dict_writer.writerows(to_csv)
