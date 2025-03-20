#!/bin/bash

last_day=$(git log --pretty=format:"%s" | grep -o 'Day [0-9]*' | head -n 1 | awk '{print $2}')
next_day=$((last_day + 1))

if [ -z "$last_day" ]; then
    next_day=1
fi

commit_message="feat(dsa): solve Day $next_day problems - recursion, strings, arrays, manipulation"

git add .
git commit -m "$commit_message"
git push origin main

echo "✅ Committed: $commit_message"