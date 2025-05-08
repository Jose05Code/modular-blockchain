
# Changelog

## [v1.0.0] - First Stable Release

### ✨ What's Included

This is the first stable release of a modular and educational blockchain built in Java.

It includes all the core functionality required to simulate a minimal blockchain system:

### ✅ Core Features

- Basic `Block` structure with `previousHash`, `nonce`, `timestamp`, `transactions`
- Blockchain class with validation logic (`isValidLinkToChain`)
- Cryptographically signed transactions (ECDSA) with verification
- Mining logic with adjustable difficulty
- User key generation using elliptic curve (`secp256r1`)
- Clean output via `DisplayUtils` and structured logs via `LoggerUtils`
- Organized codebase with clear package separation (`core`, `util`, `app`)
- Prepared for JSON-based storage (coming in next version)

### 📦 Directory Structure

```
src/
├── app/         # Entry point (Main)
├── core/        # Block, Blockchain, Transaction, User
└── util/        # LoggerUtils, DisplayUtils, CryptoUtils, etc.
```

### 🚀 How to Run

1. Clone the repo
2. Open in IntelliJ or your Java IDE
3. Run `Main.java` to simulate a blockchain session

### 🔜 Coming Next

- Persistent blockchain storage using JSON
- Transaction pool refinement
- CLI or interactive GUI
- Multi-node or networking simulation

### 🛡 License

MIT — Free to use and modify for learning and experimentation.
