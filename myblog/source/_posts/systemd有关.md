---
layout: 一些 
title: systemd
date: 2025-04-05 14:59:22
tags:
---

好的！我们来把 Linux 中 **systemd 服务的状态** 讲得清清楚楚，包括它的几个主要 **状态分类**、每个字段的意义、常见的状态组合，并且带上**图解风格思维导图式分类**👇

---

## 🧱 一、服务状态的 3 个关键字段（在 `systemctl` 中）

| 字段 | 意义 | 举例 |
|------|------|------|
| **LOAD** | 是否成功加载了 unit 文件 | `loaded` / `not-found` |
| **ACTIVE** | 高层次的活跃状态（是否正在工作） | `active` / `inactive` / `failed` |
| **SUB** | 具体的子状态，描述服务的运行细节 | `running` / `exited` / `dead` |

---

## 🧩 二、服务状态分类（思维导图风格）

```
服务状态 (systemctl list-units)
├── LOAD
│   ├── loaded         # unit 文件已成功加载
│   ├── not-found      # unit 文件不存在
│   └── bad-setting    # 配置错误
│
├── ACTIVE
│   ├── active         # 服务正常运行中
│   ├── inactive       # 没有运行
│   ├── activating     # 正在启动中
│   ├── deactivating   # 正在关闭中
│   └── failed         # 启动失败
│
└── SUB
    ├── running        # 正常运行中（持续进程）
    ├── exited         # 启动后立即退出（短生命周期，如一次性脚本）
    ├── waiting        # 守护进程等待事件触发（常见于 socket 服务）
    ├── dead           # 没有活动进程
    └── auto-restart   # 正在尝试自动重启（Restart=always）
```

---

## 🧠 三、常见状态组合（`systemctl list-units`）

| LOAD     | ACTIVE   | SUB        | 说明 |
|----------|----------|------------|------|
| loaded   | active   | running    | ✅ 正常运行中（如 ssh、nginx） |
| loaded   | active   | exited     | ✅ 运行后退出（如一次性任务） |
| loaded   | inactive | dead       | ⚠️ 未启动服务但配置没问题 |
| loaded   | failed   | failed     | ❌ 启动失败，可查日志 |
| not-found| inactive | dead       | ❌ unit 文件都找不到 |
| loaded   | active   | waiting    | 💤 守候中（如 socket 触发服务） |

---

## 🔧 四、如何排查异常状态

| 状态 | 原因分析 | 排查方法 |
|------|----------|----------|
| `failed` | 启动失败 | `journalctl -xe` 或 `systemctl status 服务名` |
| `exited` | 脚本类服务执行完退出（正常） | 查看是否需要持久运行 |
| `inactive` | 没启动或被停止了 | `systemctl start 服务名` 启动它 |
| `masked` | 被管理员禁用启动了 | `sudo systemctl unmask 服务名` 解锁 |

---

## 🎯 五、查看单个服务状态（命令）

```bash
systemctl status nginx
```

输出包括：

- Loaded: 文件路径
- Active: 状态 + 时间
- Process: PID 等信息
- 日志片段（类似 tail）

---

## ✅ 例子讲解：`systemctl status ssh`

```
● ssh.service - OpenBSD Secure Shell server
   Loaded: loaded (/lib/systemd/system/ssh.service; enabled)
   Active: active (running) since ...
 Main PID: 938
```

说明：
- Unit 文件成功加载（loaded）
- 当前正在运行（active）
- 是持续服务（sub: running）
- 设置了开机自启（enabled）

---

如果你发我一条你机器上 `systemctl status xxx` 的输出，我可以帮你读懂它的状态和建议怎么处理～是否要我也画张小图帮助你记忆这几个状态关系？
