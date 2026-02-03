# 🌙 CLunarCheck

> Plugin Spigot focado em **detecção real do LunarClient** usando o canal oficial **Apollo**.  
> Desenvolvido para servidores **Minecraft 1.8.x** com uma abordagem limpa, leve e sem dependências externas.

---

## ✨ O que é o CLunarCheck?

O **CLunarCheck** é um plugin que verifica, no momento em que o jogador entra no servidor, se ele está realmente utilizando o **LunarClient oficial**.

Diferente de métodos antigos baseados em *client brand* (facilmente falsificáveis), este plugin utiliza:

✅ Canal oficial `lunar:apollo`  
✅ Registro real de plugin channels  
✅ Handshake ativo com o cliente  
✅ Sistema de sessão por jogador  

Isso torna o bypass significativamente mais difícil para clientes falsos.

---

## 🚀 Funcionalidades

- 🔐 Detecção real via **Apollo**
- ⚡ Verificação automática ao entrar no servidor
- 🧠 Sistema de sessão por UUID
- 💬 Feedback visual direto no chat
- ⏱ Exibe tempo total da verificação
- 🧩 API interna (`isRealLunar(Player)`)
- 🧹 Código limpo, sem sons e sem checks desnecessários
- 📦 Zero dependências externas

---

## 🧩 Como funciona?

O fluxo de verificação é o seguinte:

1. Jogador entra no servidor  
2. Plugin cria uma sessão para o jogador  
3. Verifica se o canal `lunar:apollo` está registrado  
4. Envia um *handshake* para o cliente  
5. Aguarda resposta do Apollo  
6. Avalia os três pontos principais:

```
lunar:apollo registrado?
pacote recebido?
handshake respondido?
```

Se todos forem verdadeiros:

➡️ **LUNAR REAL CONFIRMADO**

Caso contrário:

➡️ **CLIENTE SUSPEITO**

Tudo isso acontece automaticamente em poucos milissegundos.

---

## 📦 Compatibilidade

| Item | Suporte |
|------|--------|
| Minecraft | ✅ 1.8.x |
| Spigot | ✅ Sim |
| Paper | ✅ Sim |
| Java | ✅ 8 |
| ProtocolLib | ❌ Não necessário |

> ⚠️ Este plugin foi pensado especificamente para servidores 1.8.x.

---

## 🛠 Instalação

1. Compile o projeto ou baixe o `.jar`
2. Coloque em:

```
/plugins
```

3. Reinicie o servidor

Pronto — nenhuma configuração adicional é necessária.

---

## 💬 Exemplo no jogo

Ao entrar:

```
[CLunarCheck] Iniciando verificação Lunar...
[CLunarCheck] ✔ lunar:apollo registrado
[CLunarCheck] ✔ lunar:apollo ativo
----------------------
LUNAR REAL CONFIRMADO
Tempo: 312ms
----------------------
```

Ou, caso falhe:

```
CLIENTE SUSPEITO
```

---

## 🧠 API interna

Você pode consultar o resultado em outros plugins:

```java
Main.plugin.isRealLunar(player);
```

Retorna:

- `true` → Lunar real
- `false` → suspeito / não Lunar

---

## 🔒 Segurança

Nenhum método server-side é 100% infalível.

Porém, este plugin já bloqueia:

- Fake Lunar básico
- Spoof simples
- Skid clients
- Brand spoof

Ele utiliza o mesmo conceito empregado por servidores maiores:  
👉 **Apollo + Handshake + Channel validation**

---

## 🗺 Roadmap (ideias futuras)

- ⛔ Kick automático para fake Lunar
- 📊 Sistema de score
- 📡 Webhook Discord
- 🧑‍⚖ Permissão de bypass para staff
- 📋 Comando `/lunarcheck`

---

## 👤 Autor

**Coopas**

---

## 📄 Licença

Este projeto é livre para uso e modificação.  
Créditos são apreciados 🙂

---

⭐ Se este projeto te ajudou, considere deixar uma estrela no repositório!
