#!/bin/bash

# Get the last recorded day from commit messages
last_day=$(git log --pretty=format:"%s" | grep -o 'Day [0-9]*' | head -n 1 | awk '{print $2}')

# If no previous day is found, start from 1
if [ -z "$last_day" ]; then
    next_day=1
else
    next_day=$((last_day + 1))
fi

# Define the commit message
commit_message="feat(dsa): solve Day $next_day problems - subarray, substrings, using two pointers and sliding window"

# Add changes, commit, and push
git add .
git commit -m "$commit_message"
git push origin main

# Print success message
echo "✅ Committed: $commit_message"