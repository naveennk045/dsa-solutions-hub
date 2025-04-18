#!/bin/bash

# Define the commit message
commit_message="feat(dsa): solve  problems - subarray , substrings using two pointers , sliding window and prefix sum"

# Add changes, commit, and push
git add .
git commit -m "$commit_message"
git push origin main

# Print success message
echo "✅ Committed: $commit_message"