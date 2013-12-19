TEX = pdflatex

.PHONY: all clean

all: rapport

raport: rapport.tex
	$(TEX)  $^

view:
	open rapport.pdf

clean:
	rm -rf *~
	rm -rf *.aux
	rm -rf *.out
	rm -rf *.log
