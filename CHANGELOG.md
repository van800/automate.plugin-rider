# Changelog

All notable changes to this project are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Notes

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [1.0.4] - 2022-09-29

### Notes

- Minimum compatibility with `automate` version 1.0.2

### Added

- General: Closed #2. Self-installs automate CLI tool on the local machine
- General: Closed #2. Auto-upgrades compatible version of automate CLI on the local machine
- Drafts: Advanced #5. Added menu items for running commands configured on drafts.
- Patterns: Fixed #13. Added editing of choices for attributes.

### Fixed

- Drafts: Fixed #10. Able to edit draft properties that have no value.
- General: Fixed #11. Moved settings to non-source controlled persistence.

## [1.0.3]

### Fixed

- General: Fixed #9. CLI commands are no longer wrapped in double-quotes, which do not work reliably on macOS or Linux
- Drafts: Fixed #4. Adding a new draft or selecting another draft does not update the selected item in the dropdown list
  in the toolbar.

## [1.0.2] - 2022-09-20

### Notes

- (First public stable release)
- Minimum compatibility with `automate` version 1.0.1

### Added

- Introduces a tool window for viewing toolkits, and drafts
- Drafts: Creation of drafts
- Drafts: Viewing of drafts
- Drafts: Editing of drafts
- Patterns: Creation of patterns
- Patterns: Editing of pattern attributes (only)
- Settings: Editing of installation location of automate.exe executable
- Settings: Viewing of CLI commands
- Settings: Added "Authoring Mode"

## [1.0.1-Unstable] - 2022-06-24

### Notes

- (initial version - not released to public)