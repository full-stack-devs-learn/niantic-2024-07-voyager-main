#!/bin/bash

# The script prompts the user for name and email to configure the global settings. It also sets
# their diff tool settings and setting the upstream repository.

echo
read -r -p "Enter your name (First Last): " name
read -r -p "Enter your email: " email

echo
echo "Setting Up Global Configuration Settings"

git config --global user.name "${name}"
git config --global user.email "${email}"

echo "Setting up Git Editors and Tools..."

git config --global core.editor "code -w -n"
git config --global diff.tool code
git config --global difftool.code.cmd "code -w -d \$LOCAL \$REMOTE"

echo
echo "Configuring Upstream..."

git remote add upstream "https://github.com/full-stack-devs-learn/niantic-2024-07-voyager-main.git"
git config branch.main.mergeOptions "--no-edit"

echo "Done."