# architecture - Claude Code Instructions

> **Note**: For personal assistant instructions and general context, see `AGENTS.md`. This file focuses on development-specific instructions.

## ⚠️ CRITICAL RULES - READ FIRST

**STOP AFTER PUSHING. NEVER CREATE PRS WITHOUT EXPLICIT PERMISSION.**

Even if the user says "go for it" or "do it" - that does NOT mean create a PR. After pushing a branch, ALWAYS explicitly ask: "Should I create a PR?" and wait for confirmation before running `gh pr create`.

**When to commit/push:**
- Only when explicitly told to commit/push
- When user says "yes" to "should I commit this?"

**When to create PRs:**
- ONLY when explicitly told "create a PR" or "open a PR"
- ONLY after explicitly asking "Should I create a PR?" and receiving confirmation
- NEVER assume permission from "go for it", "do it", "yes", etc.

## Project Overview

This repository serves as a personal assistant home base. This project also uses **Codev** for AI-assisted development when needed.

## Available Protocols

- **SPIDER**: Multi-phase development with consultation (`codev/protocols/spider/protocol.md`)
- **TICK**: Fast autonomous implementation (`codev/protocols/tick/protocol.md`)
- **EXPERIMENT**: Disciplined experimentation (`codev/protocols/experiment/protocol.md`)
- **MAINTAIN**: Codebase maintenance (`codev/protocols/maintain/protocol.md`)

## Key Locations

- **Specs**: `codev/specs/` - Feature specifications (WHAT to build)
- **Plans**: `codev/plans/` - Implementation plans (HOW to build)
- **Reviews**: `codev/reviews/` - Reviews and lessons learned
- **Protocols**: `codev/protocols/` - Development protocols

## Quick Start

1. For new features, start with the Specification phase
2. Create exactly THREE documents per feature: spec, plan, and review
3. Follow the protocol phases as defined in the protocol files
4. Use multi-agent consultation when specified

## File Naming Convention

Use sequential numbering with descriptive names:
- Specification: `codev/specs/0001-feature-name.md`
- Plan: `codev/plans/0001-feature-name.md`
- Review: `codev/reviews/0001-feature-name.md`

## Git Workflow

**NEVER use `git add -A` or `git add .`** - Always add files explicitly.

**NEVER automatically commit code** - Always ask the user first before committing changes, unless explicitly told to commit.

**NEVER automatically create PRs** - Even after pushing a branch, STOP and explicitly ask "Should I create a PR?" before running `gh pr create`. "Go for it" or "do it" does NOT mean create a PR - wait for explicit "create a PR" or "yes" to your question.

Commit messages format:
```
[Spec 0001] Description of change
[Spec 0001][Phase: implement] feat: Add feature
```

## CLI Commands

Codev provides three CLI tools:

- **codev**: Project management (init, adopt, update, doctor)
- **af**: Agent Farm orchestration (start, spawn, status, cleanup)
- **consult**: AI consultation for reviews (pr, spec, plan)

For complete reference, see `codev/resources/commands/`:
- `codev/resources/commands/overview.md` - Quick start
- `codev/resources/commands/codev.md` - Project commands
- `codev/resources/commands/agent-farm.md` - Agent Farm commands
- `codev/resources/commands/consult.md` - Consultation commands

## Configuration

Customize Agent Farm behavior in `codev/config.json`:

```json
{
  "shell": {
    "architect": "claude",
    "builder": "claude",
    "shell": "bash"
  }
}
```

## For More Info

Read the full protocol documentation in `codev/protocols/`.
