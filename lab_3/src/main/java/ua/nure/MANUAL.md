### *Call Agent*

<span style="color:#f487c6">**BlockingQueue**</span> - інтерфейс для вирішення проблеми producer-consumer, тобто коли
потік намагається додати елемент
до черги, яка вже повністю заповнена, або навпаки прочитати/забрати елемент з порожньої черги. BlockingQueue can be
shared between threads without any explicit synchronization.

<span style="color:yellow">*add()*</span> - повертає true якщо додавання успішне, в іншому випадку видикає
IllegalStateException  
<span style="color:yellow">*put()*</span> - додає елемент до черги, або за необхідністю чекає поки звільниться місце і
тоді вже додає  
<span style="color:yellow">*offer()*</span> - повертає true якщо додавання було успішне. в іншому випадку поверне
false  
<span style="color:yellow">*offer(timeout)*</span> - намагається додати елемент до черги та чекає певний час, якщо всі
слоти зайняті

<span style="color:yellow">*take()*</span> - чекає на перший елемент у черзі та забирає його. якщо черга порожня -
операція блокується та очікує поки буде доступний елемент  
<span style="color:yellow">*poll(timeout)*</span> - так само як і take(), але чекає певний час і повертає null, якщо
елемент таки не з'являється
---
<span style="color:#f487c6">**Thread.sleep()**</span> - останавливает работу/выполнение потока на какое-то время и по
его истечению возобновляет
выполнение.
---
<span style="color:#f487c6">**printStackTrace()**</span> - метод, який друкує лінії коду, де відбувалися виклики, що
призвели до помилки
---
<span style="color:#f487c6">**InterruptedException**</span> - checked exception, який виникає, коли потік був
перерваний, виконувавши операцію,
що може бути перервана, наприклад: Thread.sleep(), wait(), join(), BlockingQueue.take(). Переривання потоку не
обов'язково зупиняє поотік. Це більше як запит на переривання. І якщо у іншого потоку десь у коді перевіряється на
isInterrupted, то цей потік зреагує на переривання. Якщо ні то ні.

### *CallCenter*

<span style="color:#f487c6">**ExecutorService**</span> - інтерфейс для управління потоками. дозволяє не створювати
власноруч потоки, а просто надсилати таски до сервісу, який вже розподіляє їх між потоками.

<span style="color:yellow">*execute(Runnable command)*</span> - Executes the given Runnable task at some point in the
future. It does not provide a way to get the result or status of the task.

<span style="color:yellow">*submit(Runnable task)*</span> - Submits a Runnable task for execution and returns a Future
representing that task. The Future can be used to check if the task is complete.

<span style="color:yellow">*\<T> submit(Callable\<T> task)*</span> - Submits a Callable task for execution and returns a
Future representing the result of the task. The Future's get() method can be used to retrieve the result (it will block
until the result is available).

<span style="color:yellow">*shutdown()*</span> - Initiates an orderly shutdown in which previously submitted tasks are
executed, but no new tasks will be accepted.

- Once shutdown() is called, the ExecutorService will reject any new tasks
  submitted via execute() or submit(). These attempts will typically result in a RejectedExecutionException.


- All tasks that have been submitted before the shutdown() call **will continue to execute until they complete**
  normally. The threads currently running these tasks will finish their work.


- The underlying thread pool will remain active until all submitted tasks have finished.


- The shutdown() method itself does not forcefully interrupt or terminate the threads that are currently running. It
  politely tells the ExecutorService to stop accepting new work and to let the existing work finish.


- Once all the current tasks are completed, the factory can then be fully closed down

<span style="color:yellow">*shutdownNow()*</span> - Attempts to stop all actively executing tasks, halts the processing
of waiting tasks, and returns a list of the tasks that were awaiting execution.

- Takes a more forceful approach than shutdown().


- Just like shutdown(), shutdownNow() prevents the submission of any new tasks.


- Attempts to stop all actively executing tasks by calling interrupt() on their threads.


- Returns a List of all tasks that were submitted but had not yet started executing. These tasks will not be executed.

<span style="color:yellow">*awaitTermination(long timeout, java.util.concurrent.TimeUnit unit)*</span> - Blocks until
all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is
interrupted, whichever happens first.

<span style="color:yellow">*\<T> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable\<T>>
tasks)*</span> - Executes the given tasks, returning a list of Futures holding their status and results when all
complete

<span style="color:yellow">*\<T> invokeAny(java.util.Collection<? extends java.util.concurrent.Callable\<T>>
tasks)*</span> - Executes the given tasks, returning the result of one that has completed successfully (i.e., without
throwing an exception)
---
<span style="color:#f487c6">**volatile**</span> - variable modifier ensuring that its value is always read from and
written to main memory, not the CPU cache. This guarantees visibility of changes across threads, addressing potential
data inconsistency issues in concurrent programming.

---

<span style="color:#f487c6">**LoggerFactory.getLogger(CallCenter.class)**</span>

<span style="color:yellow">***LoggerFactory***</span> - This is a class provided by SLF4j. It provides a common API that
your application code can use for logging.

<span style="color:yellow">*getLogger()*</span> - This is a static method of the LoggerFactory class. Its purpose is to
get a logger instance.

<span style="color:yellow">*(CallCenter.class)*</span> - This line of code is asking the SLF4j framework to provide a
logger instance that is specifically associated with the CallCenter class.

---

<span style="color:#f487c6">**Executors.newFixedThreadPool**</span>

<span style="color:yellow">***Executors***</span> - Utility class in Java's java.util.concurrent package that provides
factory methods for creating various kinds of ExecutorService instances


<span style="color:yellow">**newFixedThreadPool(int nThreads)**</span> - 

<span style="color:yellow">**newCachedThreadPool()**</span> - 

<span style="color:yellow">**newSingleThreadExecutor()**</span> - 

<span style="color:yellow">**newScheduledThreadPool(int corePoolSize)**</span> - 

<span style="color:yellow">**newSingleThreadScheduledExecutor()**</span> - 

<span style="color:yellow">**newWorkStealingPool()**</span> - 

---
<span style="color:#f487c6">**new ArrayBlockingQueue<>(10)**</span> -

<span style="color:#f487c6">**callQueues.get(minQueueIndex).offer(call)**</span> -

### *Organization*

<span style="color:#f487c6">**System.currentTimeMillis()**</span> -

<span style="color:#f487c6">**random.nextInt(10)**</span> - 



