# build-names

> Heavily inspired by this repository: https://github.com/fnichol/names

A simple cli tool that generates random hyphenated names in an `adjective-noun` format that can be used to identify builds.

After installation simply run `build-names` in your command line to get a single option.

Example output after running `build-names`:

```
$ build-names
> abject-hands
```

## Installation

`curl -o- https://raw.githubusercontent.com/graingiant/build-names/0.0.2/scripts/install.sh | bash`

or

`wget -qO- https://raw.githubusercontent.com/graingiant/build-names/0.0.2/scripts/install.sh | bash`

After installation, the file binary should be in your `/usr/local/bin` directory. Either restart your terminal application or `source` your profile again.

## Options

```
-i --integer "Append random integer to names generated (Ex: abject-hands-0843)"
-d --date "Append todays date to the names generates (Ex: abject-hands-2022-03-13)"
-n --number "Number of names to generate"
-a --alliterate "Make sure the word pairs are alliterative (Ex: abject-animal)"
```

The options `-i` and `-d` will be read in the order given. For example: `-i -d` would yield `abject-hands-9876-2022-03-13` and `-d -i` would yield `abject-hands-2022-03-13-6877`

## License

Copyright 2022 Alex Caza (graingiant / [alexcaza.com](https://alexcaza.com))

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
