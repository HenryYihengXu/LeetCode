import sys

def line_wrap(file, maxLength):
	with open(file, "r") as f:
		lines = f.readlines()
		ff = open(file.split('.')[-2] + "_wrapped." + file.split('.')[-1], "w+")

		words = []
		for line in lines:
			line = line[0:-1]
			if line != "":
				words += line.split(" ")
				continue
			newline = words[0]
			for i in range(1, len(words)):
				word = words[i]
				if len(newline) + 1 + len(word) <= maxLength:
					newline += " " + word
				else:
					ff.write(newline + '\n')
					newline = word
			ff.write(newline + '\n\n')
			words = []
		

if __name__ == '__main__':
	line_wrap(sys.argv[1], 80)
