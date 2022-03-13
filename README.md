# build-name

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
`wget -q0- https://raw.githubusercontent.com/graingiant/build-names/0.0.2/scripts/install.sh | bash`

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

Copyright © 2022 Alex Caza

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
