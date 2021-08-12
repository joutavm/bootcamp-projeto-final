# Contribution and Pull Requests Etiquette

- [Contribution and Pull Requests Etiquette](#contribution-and-pull-requests-etiquette)
    - [Pull Requests Traits](#pull-requests-traits)
    - [What constitutes a good PR?](#what-constitutes-a-good-pr)
    - [Internal PR agreements](#internal-pr-agreements)
        - [Discussions](#discussions)
    - [Guidelines](#guidelines)
        - [Everyone](#everyone)
        - [Having Your Code Reviewed](#having-your-code-reviewed)
        - [Reviewing Code](#reviewing-code)
    - [Keep the flow going](#keep-the-flow-going)
    - [With a descriptive commits story](#with-a-descriptive-commits-story)
    - [Merge Strategy](#merge-strategy)
    - [Changelog](#changelog)
        - [07/08/20 - Version 3](#070820---version-3)
        - [07/08/20 - Version 2](#070820---version-2)
        - [24/07/20 - Initial version](#240720---initial-version)
    - [References / Inspiration](#references--inspiration)


Pull Requests (PR) are the fundamental unit of progress and the vehicle to deliver value and new features to our users.
A good Pull Request should match a task from the backlog, and it should take 2 or 3 days of effort to complete it. If your PR takes more time, it means your tasks could be decomposed into smaller ones. The smaller the tasks, the smaller the PR, hence easier to review the code. Not to mention it will be easier to revert if something goes wrong. It's not easy at the beginning, but the reviewers (remember, you're one of them!) will thank you.

Design discussions should be taken outside the scope of the PR. While yes, in the Open Source world, the PR is the place to have design and code style discussions, we work at same team and for the same company. If we're having too many design discussions in a PR, this means we haven't designed our feature correctly and haven't asked for feedback from more experienced team members in advance. If this happens, please talk with your team members. Not only its a great way to understand the existing codebase, good communication is essential for a healthy and productive team.

## Pull Requests Traits

| Trait                            | Value             |
| -------------------------------- | ----------------- |
| Creation/work time               | 2 - 3 days aprox. |
| Time to review a PR              | < 1 day           |
| # of approvals needed to merge   | 1                 |
| # of reviewers assigned to merge | 2+                |
| Suggested # of files per PR      | < 10              |

## What constitutes a good PR?

A good quality PR will have the following characteristics:

- It will be a complete piece of work that adds value in some way.
- It will be composed following the PR template used in this repo.
- It will have a link to the task from the backlog in Jira: "Fixing determination rules for BRA. GEN-231"
- It will have a title that reflects the work within, and a summary that helps to understand the context of the change.
- There will be well written commit messages, with well crafted commits that tell the story of the development of this work. See [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/).
- Ideally it will be small and easy to understand.
- The code contained within will meet the best practices set by the team wherever possible.

A PR does not end at submission though. A code change is not made until it is merged and used in production.
A good PR should be able to flow through a peer review system easily and quickly.

## Internal PR agreements

- PR creator has the responsability to **merge** the code once the PR has been approved
- PR creator has the responsability to delete the PR branch once merged
- Team must not leave unfinished, stale or orphan branches in the repo. If something needs to be parked, mark the PR as *draft*.
- Drafts can also be reviewed, though it is not enforced and the rules above do not apply
- Remote branches must be deleted upon merge
- No orphan PRs, always assign yourself when creating a PR
- Every request for review should be fulfilled
- Assign 2+ reviewers to every PR

### Discussions

- Discussions **must be kept polite** and every remark should be well received. No exceptions.
- No linting discussions, unless stricly necessary. Make sure to format your code before submitting any file
- Remarks on good code and practices are encouraged
    - Must be resolved by the PR owner. If the error persists it should be remarked in a new review
    - Be a good team player and show valid arguments

## Guidelines

### Everyone

* Accept that many programming decisions are opinions. Discuss tradeoffs, which
  you prefer, and reach a resolution quickly.
* Remember that you are here to provide feedback, **not to be a gatekeeper**.
* Ask good questions; don't make demands. ("What do you think about naming this
  `:user_id`?")
* Good questions avoid judgment and avoid assumptions about the author's
  perspective.
* Ask for clarification. ("I didn't understand. Can you clarify?")
* Avoid selective ownership of code. ("mine", "not mine", "yours")
* Avoid using terms that could be seen as referring to personal traits. ("dumb",
  "stupid"). Assume everyone is intelligent and well-meaning.
* Be explicit. Remember people don't always understand your intentions online.
* Be humble. ("I'm not sure - let's look it up.")
* Don't use hyperbole. ("always", "never", "endlessly", "nothing")
* Don't use sarcasm.
* Keep it real. If emoji, animated gifs, or humor aren't you, don't force them.
  If they are, use them with aplomb.
* Talk synchronously (e.g. chat, screensharing, in person) if there are too many
  "I didn't understand" or "Alternative solution:" comments. Post a follow-up
  comment summarizing the discussion.

### Having Your Code Reviewed

* Be grateful for the reviewer's suggestions. ("Good call. I'll make that
  change.")
* A common axiom is "Don't take it personally. The review is of the code, not you." We used to include this, but now prefer to say what we mean: Be aware of [how hard it is to convey emotion online] and how easy it is to misinterpret feedback. If a review seems aggressive or angry or otherwise personal, consider if it is intended to be read that way and ask the person for clarification of intent, in person if possible.
* Keeping the previous point in mind: assume the best intention from the reviewer's comments.
* Explain why the code exists. ("It's like that because of these reasons. Would
  it be more clear if I rename this class/file/method/variable?")
* Extract some changes and refactorings into future tickets/stories.
* Link to the code review from the ticket/story. ("Ready for review:
  https://github.com/organization/project/pull/1")
* Push commits based on earlier rounds of feedback as isolated commits to the
  branch. Do not squash until the branch is ready to merge. Reviewers should be
  able to read individual updates based on their earlier feedback.
* Seek to understand the reviewer's perspective.
* Try to respond to every comment.
* Wait to merge the branch until continuous integration (Jenkins, Travis CI,
  CircleCI, etc.) tells you the test suite is green in the branch.
* Merge once you feel confident in the code and its impact on the project.

### Reviewing Code

Understand why the change is necessary (fixes a bug, add value to the users, refactors the existing code). Then:

* Communicate which ideas you feel strongly about and those you don't.
* Identify ways to simplify the code while still solving the problem.
* If discussions turn too philosophical or academic, move the discussion offline
  to a regular Friday afternoon technique discussion. In the meantime, let the
  author make the final decision on alternative implementations.
* Offer alternative implementations, but assume the author already considered
  them. ("What do you think about using a custom validator here?")
* Seek to understand the author's perspective.
* Sign off on the pull request with a :thumbsup:, "LGTM" (looks good to me) or "Ready to merge" comment.

## Keep the flow going

If PRs are getting clogged up in the system, either unreviewed or unmanaged, they are preventing a piece of work from being completed.

As PRs clog up in the system, merges become more difficult, as other features and fixes are applied to the same codebase. This in turn slows them down further, and often completely blocks progress on a given codebase.

There is a balance between flow and ensuring the quality of our PRs. As a reviewer you should make a call as to whether a code quality issue is sufficient enough to block the PR whilst the code is improved. Possibly it is more prudent to simply flag that the code needs rework, and raise an issue.

Any quality issue that will obviously result in a bug should be fixed.

If you disagree with a guideline, open an issue on the guides repo rather than
debating it within the code review. In the meantime, apply the guideline.

## With a descriptive commits story

When developing a feature, we should ask us the following questions:
- Are the commits in this branch telling us how the feature evolved or was developed?
- Am I telling the whole story of my feature?
- Do the commits have descriptive names?
- Is there any repeated commit? Example: Fix1 => Fix2 => Add test => Add More Tests

In this team, there is no one right way to design the confirmation story, but these questions must be present in every development of each of us.

## Merge Strategy

There are multiple merge strategies at this moment, and almost all of them are viable.
The following is the one we use in this team:
1. [Design the commits' story of your feature branch](#with-a-descriptive-commits-story)
2. Create Pull Request to Develop. Once approved merge applying **Rebase and Merge** strategy
3. When you create a Release and want to merge it into Master, you must apply **Merge and commit** strategy
4. When a backport to Develop is created, merge it applying **Merge and Commit** strategy.

## Changelog
#### 07/08/20 - Version 3
- Feedback from @emiguens
#### 07/08/20 - Version 2
- add commits' story and merge strategy
#### 24/07/20 - Initial version
- initial version

## References / Inspiration

- https://gist.github.com/mikepea/863f63d6e37281e329f8
- https://github.com/thoughtbot/guides/tree/master/code-review
- https://lab.github.com/githubtraining/reviewing-pull-requests
- https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/about-pull-requests