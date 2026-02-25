# Personal Assistant Home Base

This repository serves as a personal assistant home base, utilizing AI-assisted development workflows.

---

# About Codev

This project uses **Codev** for AI-assisted development. Below is the full documentation from the Codev project.

Source: https://github.com/cluesmith/codev (Apache 2.0 License)

---

# Codev: A Human-Agent Software Development Operating System

[![npm version](https://img.shields.io/npm/v/@cluesmith/codev.svg)](https://www.npmjs.com/package/@cluesmith/codev)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

![Agent Farm Dashboard](https://raw.githubusercontent.com/cluesmith/codev/main/docs/assets/agent-farm-hero.png)

> **New: [A Tour of CodevOS](https://waleedk.medium.com/a-tour-of-codevos-1db0fe0e4516)** — A deep dive into how Codev orchestrates human-agent collaboration: the SPIR protocol, Agent Farm, multi-model consultation, and the architecture that ties it all together.

Codev is an operating system for structured human-AI collaboration. You write specs and plans that AI agents execute reliably.

> **Results**: One architect + autonomous AI builders shipped [106 PRs in 14 days](https://github.com/cluesmith/codev/blob/main/codev/resources/development-analysis-2026-02-17.md), median feature in 57 minutes. In controlled comparison, SPIR consistently outperformed unstructured AI coding across [4 rounds](https://github.com/cluesmith/codev/blob/main/codev/resources/vibe-vs-spir-r4-comparison-2026-02.md).

**Quick Links**: [FAQ](https://github.com/cluesmith/codev/blob/main/docs/faq.md) | [Tips](https://github.com/cluesmith/codev/blob/main/docs/tips.md) | [Cheatsheet](https://github.com/cluesmith/codev/blob/main/codev/resources/cheatsheet.md) | [CLI Reference](https://github.com/cluesmith/codev/blob/main/codev/resources/commands/overview.md) | [Why Codev?](https://github.com/cluesmith/codev/blob/main/docs/why.md) | [Discord](https://discord.gg/mJ92DhDa6n)

📬 **Stay updated** — [Subscribe to the Codev newsletter](https://marketmaker.cluesmith.com/subscribe/codev) for release notes, tips, and community updates.

## Table of Contents

- [Quick Start](#quick-start)
- [Learn About Codev](#learn-about-codev)
- [What is Codev?](#what-is-codev)
- [The SPIR Protocol](#the-spir-protocol)
- [Key Features](#key-features)
- [Example Implementations](#-example-implementations)
- [Real-World Performance](#-eating-our-own-dog-food)
- [Agent Farm](#agent-farm-optional)
- [Contributing](#contributing)

## Quick Start

```bash
# 1. Install
npm install -g @cluesmith/codev

# 2. Initialize a project
mkdir my-project && cd my-project
codev init

# 3. Verify setup
codev doctor

# 4. Start the workspace (optional)
af workspace start
```

Then tell your AI agent: *"I want to build X using the SPIR protocol"*

**CLI Commands:**
- `codev` - Main CLI (init, adopt, doctor, update)
- `af` - Agent Farm for parallel AI builders
- `consult` - Multi-model consultation

See [CLI Reference](https://github.com/cluesmith/codev/blob/main/codev/resources/commands/overview.md) for details.

### Prerequisites

**Core (required):**

| Dependency | Install | Purpose |
|------------|---------|---------|
| Node.js 18+ | `brew install node` | Runtime |
| git 2.5+ | (pre-installed) | Version control |
| AI CLIs | See below | All three recommended |

**AI CLIs** (install all three for multi-model consultation):
- Claude Code: `npm install -g @anthropic-ai/claude-code`
- Gemini CLI: [github.com/google-gemini/gemini-cli](https://github.com/google-gemini/gemini-cli)
- Codex CLI: `npm install -g @openai/codex`

**Agent Farm (optional):**

| Dependency | Install | Purpose |
|------------|---------|---------|
| gh | `brew install gh` | GitHub CLI |

## Learn about Codev

### ❓ FAQ

Common questions about Codev: **[FAQ](https://github.com/cluesmith/codev/blob/main/docs/faq.md)**

### 💡 Tips & Tricks

Practical tips for getting the most out of Codev: **[Tips & Tricks](https://github.com/cluesmith/codev/blob/main/docs/tips.md)**

### 📋 Cheatsheet

Quick reference for Codev's philosophies, concepts, and tools: **[Cheatsheet](https://github.com/cluesmith/codev/blob/main/codev/resources/cheatsheet.md)**

### 📺 Quick Introduction (5 minutes)
[![Codev Introduction](https://img.youtube.com/vi/vq_dmfyMHRA/0.jpg)](https://youtu.be/vq_dmfyMHRA)

Watch a brief overview of what Codev is and how it works.

### 💬 Participate

Join the conversation in [GitHub Discussions](https://github.com/cluesmith/codev/discussions) or [Discord community](https://discord.gg/mJ92DhDa6n)! Share your specs, ask questions, and learn from the community.

### 🛠️ Agent Farm Demo: Building a Feature with AI
[![Agent Farm Demo](https://img.youtube.com/vi/0OEhdk7-plE/0.jpg)](https://www.youtube.com/watch?v=0OEhdk7-plE)

Watch a real development session using Agent Farm - from spec to merged PR in 30 minutes. Demonstrates the Architect-Builder pattern with multi-model consultation.

### 🎯 Codev Tour - Building a Conversational Todo Manager
See Codev in action! Follow along as we use the SPIR protocol to build a conversational todo list manager from scratch:

👉 [**Codev Demo Tour**](https://github.com/ansari-project/codev-demo/blob/main/codev-tour.md)

This tour demonstrates:
- How to write specifications that capture all requirements
- How the planning phase breaks work into manageable chunks
- The implementation phase in action
- Multi-agent consultation with GPT-5 and Gemini Pro
- How lessons learned improve future development

## What is Codev?

Codev is a development methodology that treats **natural language context as code**. Instead of writing code first and documenting later, you start with clear specifications that both humans and AI agents can understand and execute.

📖 **Read the full story**: [Why We Created Codev: From Theory to Practice](https://github.com/cluesmith/codev/blob/main/docs/why.md) - Learn about the journey from theory to implementation.

### Core Philosophy

1. **Context Drives Code** - Context definitions flow from high-level specifications down to implementation details
2. **Human-AI Collaboration** - Designed for seamless cooperation between developers and AI agents
3. **Evolving Methodology** - The process itself evolves and improves with each project

## The SPIR Protocol

The flagship protocol for structured development:

- **S**pecify - Define what to build in clear, unambiguous language
- **P**lan - Break specifications into executable phases
- **I**mplement - Build the code, write tests, verify requirements for each phase
- **R**eview - Capture lessons and improve the methodology

## Project Structure

After running `codev init` or `codev adopt`, your project has a **minimal structure**:

```
your-project/
├── codev/
│   ├── specs/              # Feature specifications
│   ├── plans/              # Implementation plans
│   ├── reviews/            # Review and lessons learned
│   └── resources/          # Reference materials
├── AGENTS.md               # AI agent instructions (AGENTS.md standard)
├── CLAUDE.md               # AI agent instructions (Claude Code)
└── [your code]
```

## Key Features

### 📄 Natural Language is the Primary Programming Language
- Specifications and plans drive implementation
- All decisions captured in version control
- Clear traceability from idea to implementation

### 🤖 AI-Native Workflow
- Structured formats that AI agents understand
- Multi-agent consultation support (GPT-5, Gemini Pro, etc.)
- Reduces back-and-forth from dozens of messages to 3-4 document reviews
- Supports both AGENTS.md standard (Cursor, Copilot, etc.) and CLAUDE.md (Claude Code)

### 🔄 Continuous Improvement
- Every project improves the methodology
- Lessons learned feed back into the process
- Templates evolve based on real experience

## 📚 Example Implementations

Both projects below were given **the exact same prompt** to build a Todo Manager application using **Claude Code with Opus**. The difference? The methodology used:

### [Todo Manager - VIBE](https://github.com/ansari-project/todo-manager-vibe)
- Built using a **VIBE-style prompt** approach (same model, same prompt)
- Produced boilerplate scaffolding but 0% of the specified functionality

### [Todo Manager - SPIR](https://github.com/ansari-project/codev-demo)
- Built using the **SPIR protocol** with full document-driven development
- Same requirements, but structured through formal specifications and plans
- Demonstrates all phases: Specify → Plan → Implement → Review
- Complete with specs, plans, and review documents
- Multi-agent consultation throughout the process

## 🐕 Eating Our Own Dog Food

Codev is **self-hosted** — we use Codev to build Codev. Every feature goes through SPIR. Every improvement has a spec, plan, and review.

### Production Metrics (Feb 2026)

Over a 14-day sprint building Codev with Codev:

| Metric | Value |
|--------|-------|
| Merged PRs | 106 |
| Closed issues | 105 |
| Commits | 801 |
| Median feature implementation | 57 minutes |
| Fully autonomous builders | 85% (22 of 26) |
| Pre-merge bugs caught by consultation | 20 |
| Consultation cost per PR | $1.59 |

One architect with autonomous builders matched the output of a **3-4 person elite engineering team**.

## Agent Farm (Optional)

Agent Farm is an optional companion tool for Codev that provides a web-based dashboard for managing multiple AI agents working in parallel.

**Why use Agent Farm?**
- **Web dashboard** for monitoring multiple builders at once
- **Protocol-aware** - knows about specs, plans, and Codev conventions
- **Git worktree management** - isolates each builder's changes
- **Automatic prompting** - builders start with instructions to implement their assigned spec

### Quick Start

```bash
# Start the workspace
af workspace start

# Spawn a builder for a spec
af spawn 3 --protocol spir

# Check status
af status

# Stop everything
af workspace stop
```

### Remote Access

Access Agent Farm from any device via cloud connectivity:

```bash
af tower connect
```

Register your tower with [codevos.ai](https://codevos.ai) for secure remote access from any browser.

## License

This README includes content from the Codev project (https://github.com/cluesmith/codev), which is licensed under the Apache 2.0 License.
