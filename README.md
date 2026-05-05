<p align="center">
  <img src="https://img.shields.io/badge/Minecraft-1.21.1-brightgreen" alt="Minecraft Version">
  <img src="https://img.shields.io/badge/NeoForge-21.1.227-blue" alt="NeoForge Version">
  <img src="https://img.shields.io/badge/Mod%20Version-1.0.0-orange" alt="Mod Version">
  <img src="https://img.shields.io/badge/License-All%20Rights%20Reserved-red" alt="License">
</p>

<p align="center">
  <a href="https://github.com/kihua/speed-change-minecraft-/releases">Download</a> |
  <a href="#features">Features</a> |
  <a href="#installation">Installation</a> |
  <a href="#usage">Usage</a> |
  <a href="#configuration">Configuration</a>
</p>

---

<p align="center">
  <a href="#english">🇬🇧 English</a> &nbsp;|&nbsp; <a href="#chinese">🇨🇳 中文</a>
</p>

---

<h1 align="center">SpeedChange</h1>

<p align="center">
  <b>A Minecraft NeoForge mod that lets you cycle through movement speed levels with a single key press.</b><br>
  Perfect for creative building, server administration, or just getting around faster.
</p>

---

<a name="english"></a>
<h2 align="center">🇬🇧 English</h2>

## Overview

**SpeedChange** is a lightweight Minecraft NeoForge mod (for **Minecraft 1.21.1**) that adds a configurable speed boost system. Press a key (default: **V**) to cycle through speed levels — each level increases your movement speed by a configurable amount. A HUD display shows your current speed bonus in the bottom-right corner.

### Features

- 🔄 **Cycle Speed Levels** — Press `V` (configurable) to cycle through speed levels 0 → 1 → 2 → ... → Max → 0
- ⚡ **Configurable Boost** — Each level adds a configurable speed increment (default: +10% per level)
- 📊 **HUD Display** — See your current speed bonus in the bottom-right corner of the screen
- 🖥️ **Configuration Screen** — Built-in NeoForge config screen (accessible via Mod Menu)
- 🔗 **Server-Synced** — Speed level persists on servers; works correctly in multiplayer
- 💾 **Persistent** — Speed level is preserved on death (disable by modifying the source)
- 🌐 **Multi-language** — Supports English and Chinese

### Installation

1. Install **Minecraft 1.21.1** and **NeoForge 21.1.227+**
2. Download the latest `speed-change-x.x.x.jar` from the [Releases](https://github.com/kihua/speed-change-minecraft-/releases) page
3. Place the JAR file into your `mods` folder:
   - **Client**: `.minecraft/mods/`
   - **Server**: `<server-directory>/mods/`
4. Launch the game (or restart the server)

### Usage

#### Key Binds

| Action | Default Key | Description |
|--------|-------------|-------------|
| Cycle Speed Boost | `V` | Press to cycle to the next speed level (0 → 1 → 2 → ... → Max → 0) |

> You can rebind the key in **Options → Controls → Key Binds** under the "Speed Change" category.

#### How It Works

1. Press **V** to increase your speed level
2. Each level adds a percentage boost to your base movement speed (default: +10% per level)
3. After reaching the maximum level, the next press resets to level 0 (normal speed)
4. The HUD in the bottom-right corner shows your current speed bonus (e.g., "Speed: +20%")
5. A chat message also displays the new level when you switch

#### In Multiplayer

The speed level syncs to the server — your speed boost works correctly and other players will see you moving faster. The config values must match between client and server for consistent behavior.

### Configuration

The mod uses NeoForge's standard configuration system. The config file is located at:

```
config/speed_change-common.toml
```

You can edit this file with any text editor while the game is **not running**, or change values in-game via **Mod Menu → SpeedChange → Config**.

#### Options

| Option | Type | Default | Range | Description |
|--------|------|---------|-------|-------------|
| `speed_increment` | Double | 0.1 | 0.01 ~ 10.0 | Speed boost added per level (e.g., 0.1 = +10%) |
| `max_level` | Integer | 4 | 1 ~ 20 | Maximum number of speed boost levels |

> **Tip for TOML editing**: Values take effect after a game/server restart.

### Building from Source

```bash
# Clone the repository
git clone https://github.com/kihua/speed-change-minecraft-.git
cd speed-change-minecraft-

# Build the mod
./gradlew build

# The JAR will be in build/libs/
```

### License

All Rights Reserved. See the [LICENSE](LICENSE) file for details.

---

<a name="chinese"></a>
<h2 align="center">🇨🇳 中文</h2>

## 概述

**SpeedChange（速度切换）** 是一个轻量级的 Minecraft NeoForge 模组（适用于 **Minecraft 1.21.1**），通过按键（默认 **V 键**）即可切换多个移动速度等级。每级增加可配置的速度加成，HUD 会在屏幕右下角显示当前速度加成百分比。

### 功能特性

- 🔄 **循环切换速度等级** — 按下 `V` 键（可自定义）循环切换速度等级 0 → 1 → 2 → ... → 最大等级 → 0
- ⚡ **可配置加成** — 每级增加可配置的速度加成（默认每级 +10%）
- 📊 **HUD 显示** — 屏幕右下角实时显示当前速度加成
- 🖥️ **配置界面** — 内置 NeoForge 配置界面（可通过模组菜单访问）
- 🔗 **服务器同步** — 速度等级在服务器上持久化，多人模式下正常工作
- 💾 **死亡保留** — 死亡后速度等级保留（可修改源码关闭）
- 🌐 **多语言** — 支持英文和中文

### 安装方法

1. 安装 **Minecraft 1.21.1** 和 **NeoForge 21.1.227+**
2. 从 [Releases](https://github.com/kihua/speed-change-minecraft-/releases) 页面下载最新版本的 `speed-change-x.x.x.jar`
3. 将 JAR 文件放入 `mods` 文件夹：
   - **客户端**：`.minecraft/mods/`
   - **服务器端**：`<服务器目录>/mods/`
4. 启动游戏（或重启服务器）

### 使用说明

#### 按键绑定

| 操作 | 默认按键 | 说明 |
|------|----------|------|
| 切换速度等级 | `V` | 按下后切换到下一级（0 → 1 → 2 → ... → 最大 → 0） |

> 你可以在 **选项 → 控制 → 按键绑定** 的「速度切换」分类中修改按键。

#### 工作原理

1. 按下 **V** 键提升速度等级
2. 每级增加一定比例的移动速度加成（默认每级 +10%）
3. 达到最高等级后再次按下会重置为 0 级（正常速度）
4. 屏幕右下角的 HUD 会显示当前速度加成（如"速度: +20%"）
5. 切换时聊天栏也会显示当前等级信息

#### 多人模式

速度等级会同步到服务器，你的速度加成在多人模式下生效，其他玩家也能看到你移动更快。建议客户端和服务器使用相同的配置值以保证行为一致。

### 配置说明

模组使用 NeoForge 标准配置系统，配置文件位于：

```
config/speed_change-common.toml
```

你可以在**游戏未运行时**用文本编辑器修改此文件，或在游戏中通过 **模组菜单 → SpeedChange → 配置** 修改。

#### 配置项

| 选项 | 类型 | 默认值 | 范围 | 说明 |
|------|------|--------|------|------|
| `speed_increment` | 浮点数 | 0.1 | 0.01 ~ 10.0 | 每级速度加成（如 0.1 = +10%） |
| `max_level` | 整数 | 4 | 1 ~ 20 | 最高速度等级数 |

> **TOML 编辑提示**：修改配置文件后需要重启游戏/服务器才能生效。

### 从源码构建

```bash
# 克隆仓库
git clone https://github.com/kihua/speed-change-minecraft-.git
cd speed-change-minecraft-

# 构建模组
./gradlew build

# 构建产物在 build/libs/ 目录下
```

### 许可证

All Rights Reserved。详见 [LICENSE](LICENSE) 文件。

---

<p align="center">
  Made with ❤️ by <a href="https://github.com/kihua">kihua</a>
</p>
