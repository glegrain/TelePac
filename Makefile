TEX = pdflatex

.PHONY: all clean

all: descriptif

descriptif: doc/descriptif.tex
	$(TEX) -output-directory=doc/ $^

view:
	open doc/descriptif.pdf

clean:
	rm -rf *~
	rm -rf *.aux
	rm -rf *.out
	rm -rf *.log
